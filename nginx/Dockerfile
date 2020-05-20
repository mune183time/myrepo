FROM nginx:latest
ADD app /app
ADD default.conf /etc/nginx/conf.d/default.conf
EXPOSE 80
RUN mkdir -p /run/nginx
CMD nginx -g "daemon off;"