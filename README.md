# JagtResturante

To start the Project

1. Download the project or clone from GitHub.

You can download Docker Desktop, but it's not necessary.

2. Open the project in Intellij.
3. Open the command prompt. We have used PowerShell.
4. Run the command: docker pull postgres
5. Then run command: docker run --name web-service -e POSTGRES_PASSWORD=password -d -p 5432:5432 postgres:latest
6. Your container should now be running in Docker.
7. Start your terminal in Intellij.
8. Go to your web-browser and enter: http://localhost:8080/api/v1/menu

Now you should see all the dished that are in the database.

9. To stop the container in Docker. Open PowerShell and enter: docker stop web-service

