#!/usr/bin/env bash

file="build.sh"

if [ -f ${file} ] ; then
    rm ${file}
fi

echo "Enter path to apache deploy folder: "
read folder

echo "#!/usr/bin/env bash\n" >> ${file}
echo "mvn clean install" >> ${file}
echo "mv ./target/twitter-api-3ks-1.0.0.war ${folder}" >> ${file}
echo "Created ${file} in current directory"