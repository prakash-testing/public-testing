FROM patel1678/module9
ADD . /var/www/html
ENTRYPOINT apachectl -D FOREGROUND
ENV name Devops patel1678

