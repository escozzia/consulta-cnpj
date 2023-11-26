echo "API Build..."
call cd api
call mvn clean package
call cd ..

echo "WEB Build..."
call cd web
call mvn clean package
call cd ..

call echo "Starting Docker..."
call docker-compose up

pause