//==================================================================================================
//  npm- Browserify IMPORTS
//==================================================================================================
var chartjs = require('chart.js');

//==================================================================================================
//UI- Components
//==================================================================================================
let sessionsChart = document.getElementById('sessionsChart');
let moduleChart = document.getElementById('modulesChart');
let screenVisitsChart = document.getElementById('screenVisitsChart');
let subscriptionsChart = document.getElementById('subscriptionsChart');
let refreshButton = document.getElementById('refresh_data');

//=================================================================================================
// Home Page Ajax requests
//=================================================================================================
let moduleUsageRequest = new XMLHttpRequest();
let sessionDataRequest = new XMLHttpRequest();
let screenVisitsRequest = new XMLHttpRequest();

//=================================================================================================
// EVENT LISTENERS
//=================================================================================================
refreshButton.addEventListener('click', fetchChartsData);

//=================================================================================================
//      GLOBAL CHART LOADER
//=================================================================================================

function loadChart(xLabels, label, chartDataArray, chartContext, chartType) {
    new Chart(chartContext, {
        type: chartType,
        data: {
            labels: xLabels,
            datasets: [{
                label: label,
                data: chartDataArray,
                backgroundColor: [
                    'rgba(255, 99, 132, 0.2)',
                    'rgba(54, 162, 235, 0.2)',
                    'rgba(255, 206, 86, 0.2)',
                    'rgba(75, 192, 192, 0.2)',
                    'rgba(153, 102, 255, 0.2)',
                    'rgba(255, 159, 64, 0.2)'
                ],
                borderColor: [
                    'rgba(255, 99, 132, 1)',
                    'rgba(54, 162, 235, 1)',
                    'rgba(255, 206, 86, 1)',
                    'rgba(75, 192, 192, 1)',
                    'rgba(153, 102, 255, 1)',
                    'rgba(255, 159, 64, 1)'
                ],
                borderWidth: 1
            }]
        },
        options: {
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero: true
                    }
                }]
            }
        }
    });
}


//=============================================================================
//      INIT CHARTS WITH DATA
//=============================================================================

function initScreenVisitsChart(data) {
    //initialize screen visits
    let screenVisitsChartCtx = screenVisitsChart.getContext('2d');
    let screenVisitsChartLabel = 'Screen Visits';
    let screenVisitsChartType = 'pie';
    let screenLabels = ['BudgetsActivity', 'SubscriptionActivity', 'HabitsMain', 'BudgetsMain'];
    loadChart(screenLabels, screenVisitsChartLabel, data, screenVisitsChartCtx, screenVisitsChartType);
}

/**
 * initialize subscriptions data charts
 *
 * @param {*} data
 */
function initSubscriptionChar(data) {
    let subsChartCtx = subscriptionsChart.getContext('2d');
    let subsChartLabel = 'Subscriptions';
    let subsChartType = 'bar';
    loadChart(monthDates, subsChartLabel, data, subsChartCtx, subsChartType);
}

/**
 * initialize module usage chart
 *
 * @param {*} data
 */
function initModuleUsageChart(data) {

    let labels = [];
    let entries = [];

    for (i = 0; i < data.length; i++) {
        labels.push(data[i].moduleName);
        entries.push(data[i].events);
    }

    let moduleUserChartCtx = moduleChart.getContext('2d');
    let moduleChartLabel = 'Module Usage';
    let moduleUsageChartType = 'bar';
    loadChart(labels, moduleChartLabel, entries, moduleUserChartCtx, moduleUsageChartType);
}

/**
 * Initialize Session chart with data
 *
 * @param {Array#SessionData} data
 */
function initSesionChart(data) {
    let condensedJson = JSON.parse(data);
    let dataList = condensedJson['data'];

    let habitsCount = 0;
    let productivityCount = 0;
    let financeCount = 0;
    let wellnessCount = 0;

    for (i = 0; i < dataList.length; i++) {
        let entry = dataList[i];

        if (entry.moduleName === 'Habits') {
            habitsCount++;
        } else if (entry.moduleName === "Finance") {
            financeCount++;
        } else if (entry.moduleName === 'Productivity') {
            productivityCount++;
        }
    }

    let labels = ['Habits', 'Finance', 'Productivity', 'Wellness'];
    let entries = [habitsCount, financeCount, productivityCount, wellnessCount];

    let sessionsChartCtx = sessionsChart.getContext('2d');
    let sessionChartLabel = 'Module Usage';
    let sessionChartType = 'bar';
    loadChart(labels, sessionChartLabel, entries, sessionsChartCtx, sessionChartType);

}

//==============================================================
//      FETCH DATA FROM BACKEND | AJAX SCRIPTS
//==============================================================

function fetchChartsData() {
    fetchSessionData();
    fetchModuleUsageData();
    fetchScreenVisitsData();
}

function fetchSessionData() {
    console.log('Fetching session data...');
    sessionDataRequest.onreadystatechange = handleProcessSessionDataResponse;
    sessionDataRequest.open('GET', '/analytics/user/screens/');
    sessionDataRequest.send();
}

function fetchModuleUsageData() {
    console.log('Fetching module usage data...');
    moduleUsageRequest.onreadystatechange = handleProcessModuleUsageDataResponse;
    moduleUsageRequest.open('GET', '/analytics/module/usage/');
    moduleUsageRequest.send();
}

function fetchScreenVisitsData() {
    console.log('Fetching module usage data...');
    moduleUsageRequest.onreadystatechange = handleProcessScreenVisitsData;
    moduleUsageRequest.open('GET', '/analytics/screens/');
    moduleUsageRequest.send();
}

//=========================================================================
//      AJAX RESPONSE-PROCESSORS
//=========================================================================

function handleProcessModuleUsageDataResponse() {
    try {
        if (moduleUsageRequest.status == 200) {
            let data = moduleUsageRequest.responseText;
            let jsonData = JSON.parse(data);
            initModuleUsageChart(jsonData);
        } else {
            console.log('Response Status ' + moduleUsageRequest.status);
        }
    } catch (e) {
        console.log(e);
    }
}

function handleProcessScreenVisitsData() {
    try {
        if (screenVisitsRequest.status == 200) {
            let data = screenVisitsRequest.responseText;
            let jsonData = JSON.parse(data);
            initScreenVisitsChart(jsonData);
        } else {
            console.log('Response Status ' + screenVisitsRequest.status);
        }
    } catch (e) {
        console.log(e);
    }
}


function handleProcessSessionDataResponse() {

    try {
        if (sessionDataRequest.status == 200) {
            let data = sessionDataRequest.responseText;
            let jsonData = JSON.parse(data);
            initSesionChart(jsonData);
        } else {
            console.log('Response Status ' + sessionDataRequest.status);
        }
    } catch (e) {
        console.log(e);

    }
}

fetchChartsData();
