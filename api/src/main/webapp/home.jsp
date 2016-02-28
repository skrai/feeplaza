<html>
  <head>
    <title>Fee Plaza</title>
    <!-- CSRF tokens -->
    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<base href="/home">
	<link rel="stylesheet" href="styles.css">

    <!-- 1. Load libraries -->
    <!-- IE required polyfills, in this exact order -->
    <script src="node_modules/es6-shim/es6-shim.min.js"></script>
    <script src="node_modules/systemjs/dist/system-polyfills.js"></script>

    <script src="node_modules/angular2/bundles/angular2-polyfills.js"></script>
    <script src="node_modules/systemjs/dist/system.src.js"></script>
    <script src="node_modules/rxjs/bundles/Rx.js"></script>
    <script src="node_modules/angular2/bundles/angular2.dev.js"></script>
	<script src="node_modules/angular2/bundles/router.dev.js"></script>

    <!-- 2. Configure SystemJS -->
    <script>
      System.config({
        packages: {
          homeapp: {
            format: 'register',
            defaultExtension: 'js'
          }
        }
      });
      System.import('homeapp/main')
            .then(null, console.error.bind(console));
    </script>

  </head>

  <!-- 3. Display the application -->
  <div><a href="logout">Logout</a></div>
  <body>
    <home-app>Loading...</home-app>
  </body>

</html>
