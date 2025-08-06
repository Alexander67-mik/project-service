FROM gradle:8.14.3-jdk24

WORKDIR /var/www/application

COPY . /var/www/application

CMD ["gradle", "build"]


#COPY execute.sh execute.sh
#RUN chmod +x execute.sh
#ENTRYPOINT ["./execute.sh"]