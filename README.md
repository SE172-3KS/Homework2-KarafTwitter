Twitter-API-3KS
===============

### Create build file
* Run the following command:
    * sh ./create_build_script.sh
* Enter the full path to your apache deploy folder
    * ex: /Users/my-user-name/Downloads/apache-karaf-4.0.10/deploy 
* The file build.sh should be created in the current directory

### Quick deploy:
* If any changes were made, run the following command:
    * sudo sh ./build.sh
* In the karaf console, run:
    * feature:install war
* Now, go to localhost:8181/twitter-api-3ks to see your changes!
testforjenkinschange
