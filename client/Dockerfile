
FROM node:11 
WORKDIR /app
COPY . ./
RUN yarn
RUN yarn build


RUN npm install --silent
RUN npm install react-scripts@2.1.1 -g --silent

# start app
CMD ["npm", "start"]