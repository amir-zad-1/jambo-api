![Jambo API](https://trello-attachments.s3.amazonaws.com/5ba912dca09a8d0cb6f52b2e/5bb66c81e7d56c343d5b0b6c/89d053030970723402230df2673d4a8d/proxy_form.png)

## JAMBO E-COMMERCE API

This is a SOEN-6841 Project for the the Tam Jambo.

###### Team Members
1. Amir Mohsen Hossein Zadeh-----------40039878
2. Alejandro Bernal--------------------------40043742
3. Mohamad Jafar Mohamadi Noudeh---40041319
4. Mahsa Alsadat Ghoreishi----------------40056928
5. Valeriu Caramanuta----------------------27737467
6. Samaneh Shirdel--------------------------40075615


###  Build Docker image
~~~
docker build -t gateway-api .
~~~

###  Start the app in a container
~~~
docker run -p 3001:3001 gateway-api  gateway-api
~~~


### Getting started.
1. Install Nodejs
2. Install npm
~~~
cd api-gateway
npm i
~~~

### Run the Tests.
~~~
npm test
~~~

### Run the Project.
~~~
npm start
curl http://127.0.0.1:3000
~~~