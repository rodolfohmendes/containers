FROM node:14
WORKDIR /app
COPY app/ /app/
RUN npm install express express-session body-parser ejs sqlite3
RUN node seed.js
EXPOSE 8012
CMD ["node", "app.js"]
