//==================================================================================================
//  npm- Browserify IMPORTS
//==================================================================================================
var chartjs = require('chart.js');
var $ = require('jquery');
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
let screenVisitsCount = 0;


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
    console.log("local module chart " + data);
    let labels = [];
    let entries = [];

    labels.push('Habits');
    labels.push('Productivity');
    labels.push('Finance');
    labels.push('Wellness');

    entries.push(data.get('Habits'));
    entries.push(data.get('Productivity'));
    entries.push(data.get('Finance'));
    entries.push(data.get('Wellness'));

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

async function fetchChartsData() {
    await fetchModuleUsageData();
    await fetchScreenVisits();
}

async function fetchModuleUsageData() {
    console.log('Fetching module usage data...');
    moduleUsageRequest.onreadystatechange = handleProcessModuleUsageDataResponse;
    moduleUsageRequest.open('GET', '/analytics/api/v1/module/stats/summary/');
    moduleUsageRequest.send();
}

async function fetchScreenVisits() {
    console.log('Fetching module usage data...');
    screenVisitsRequest.onreadystatechange = handleProcessScreenVisitDataResponse;
    screenVisitsRequest.open('GET', '/analytics/api/v1/user/screens/');
    screenVisitsRequest.send();
}

//=========================================================================
//      AJAX RESPONSE-PROCESSORS
//=========================================================================

function handleProcessModuleUsageDataResponse() {
    console.log("fetch module data response status " + moduleUsageRequest.status);
    try {
        if (moduleUsageRequest.status == 200) {
            console.log("Fetch module stats success " + moduleUsageRequest.status);
            let response = moduleUsageRequest.responseText;
            console.log("module usage payload " + response);
            let moduleUsageData = JSON.parse(response);
            console.log('module usage moduleUsageData ' + moduleUsageData);

            let habitsCount = moduleUsageData.habitsCount;
            let productivityCount = moduleUsageData.productivityCount;
            let wellnessCount = moduleUsageData.wellnessCount;
            let financeCount = moduleUsageData.financeCount;

            console.log('module usage: habitsCount' + habitsCount);
            console.log('module usage: productivityCount' + productivityCount);
            console.log('module usage: wellnessCount' + wellnessCount);
            console.log('module usage: financeCount' + financeCount);

            let data = new Map();
            data.set('Habits', habitsCount);
            data.set('Productivity', productivityCount);
            data.set('wellness', wellnessCount);
            data.set('Finance', financeCount);

            console.log("data map " + data);
            initModuleUsageChart(data);
        } else {
            console.log('Response Status ' + moduleUsageRequest.status);
        }
    } catch (e) {
        console.log("Error: " + e);
    }
}

function handleProcessScreenVisitDataResponse() {
    try {
        if (screenVisitsRequest.status == 200 && screenVisitsCount === 0) {
            console.log("Fetch module stats success " + screenVisitsRequest.status);
            let response = screenVisitsRequest.responseText;
            let data = JSON.parse(response);

            let table = $('.home__table');
            let tbody = table.find('tbody');
            screenVisitsCount = data.length;
            for (visit of data) {
                console.log(JSON.stringify(visit));
                tbody
                    .append($('<tr>')
                        .append($('<td>')
                            .append(visit.id)
                        ).append($('<td>')
                            .append(visit.uuid)
                        ).append($('<td>')
                            .append(visit.userTag)
                        ).append($('<td>')
                            .append(visit.activityFragmentName)
                        ).append($('<td>')
                            .append(visit.createdAt)
                        )
                    );
            }

        } else {
            console.log('Response Status ' + moduleUsageRequest.status);
        }
    } catch (e) {
        console.log("Error: " + e);
    }
}

fetchChartsData();

//-----------------------------------------------------------------------------------------
//  LOAD HOME TABLE WITH DATA
//=========================================================================================