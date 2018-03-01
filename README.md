Hello World! (WAR-style)
===============

This is the simplest possible Java webapp for testing servlet container deployments.  It should work on any container and requires no other dependencies or configuration.

###Quick deploy:
* Go into build.sh and change KARAF_DEPLOY_FOLDER to your karaf deploy directory
* If any changes were made, run the following command:
    * sh ./build.sh
    * (Append sudo to the above command if you get a permission denied)
* In karaf, run:
    * feature:install war
* Now, go to localhost:8181/twitter-api-3ks to see your changes!