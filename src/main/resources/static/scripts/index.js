var moment = require('moment');

let today = new Date();

let formatedData = moment(today).format('MMMM Do YYYY, h:mm:ss a');;

let label = document.getElementById('date_label');

label.textContent = formatedData;