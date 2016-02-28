package com.colitsys.feeplaza.service;

import com.colitsys.feeplaza.model.User;
import com.colitsys.feeplaza.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Pattern;

/**
 * Custom user authentication service.
 */
@Service("userDetailService")
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    private Pattern mMobilePattern = Pattern.compile("^\\d{10}$");

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        User user;
        if (mMobilePattern.matcher(username).matches()) {
            Long mobile = Long.parseLong(username);
            user = userRepository.findByMobile(mobile);
        } else {
            user = userRepository.findByEmail(username);
        }
        if (user == null) {
            throw new UsernameNotFoundException("user " + username + " not found.");
        }
        return new UserDetailsImpl(user);
    }

    private static class UserDetailsImpl implements UserDetails {
        private User mUser;

        UserDetailsImpl(final User user) {
            mUser = user;
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            ArrayList<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(() -> "USER");
            return authorities;
        }

        @Override
        public String getPassword() {
            return mUser.getPassword();
        }

        @Override
        public String getUsername() {
            return mUser.getName();
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
    }
}
