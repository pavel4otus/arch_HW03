#!/bin/bash
   echo "url=$1, retries=$2, timeout=$3"
   set -e
   cmd="$@"
   echo "cmd = $cmd"
   for (( i=1; i <= $2 ; i++ ))
     do
       if curl -f -s -o /dev/null $1
       then
          echo "connected"
          exec $cmd
       fi
       sleep $3
    done
    echo "error occured"
    exit 1
    
