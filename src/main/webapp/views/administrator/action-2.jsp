<%--
 * action-2.jsp
 *
 * Copyright (C) 2018 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<p><spring:message code="administrator.action.2" /></p>

<head>
<script type="text/javascript" src="scripts/Chart.min.js"></script>
</head>
<div class="chart" style="width:50%">
<canvas id="myChart"></canvas>
</div>


<jstl:set var = "allShouts"  value="${statistics.get('count.all.shouts')}" />
<jstl:set var = "longShouts"  value="${statistics.get('count.long.shouts')}" />
<jstl:set var = "shortShouts"  value="${statistics.get('count.short.shouts')}" />

<jstl:set var= "textAllShouts"><spring:message code="administrator.count.all.shouts" /></jstl:set>
<jstl:set var= "textShortShouts"><spring:message code="administrator.count.short.shouts" /></jstl:set>
<jstl:set var= "textLongShouts"><spring:message code="administrator.count.long.shouts" /></jstl:set>
<jstl:set var= "textIndicators"><spring:message code="administrator.report" /></jstl:set>


<script>

var allShouts = '${allShouts}';
var longShouts = '${longShouts}';
var shortShouts = '${shortShouts}';

var textAllShouts = '${textAllShouts}';
var textShortShouts = '${textShortShouts}';
var textLongShouts = '${textLongShouts}';
var textIndicators = '${textIndicators}';

var ctx = document.getElementById('myChart').getContext('2d');
var chart = new Chart(ctx, {
    // The type of chart we want to create
    type: 'bar',
    // The data for our dataset
    data: {
        labels: [textAllShouts, textShortShouts, textLongShouts],
        datasets: [{
            label: textIndicators,
            backgroundColor: 'rgb(0, 153, 204)',
            borderColor: 'rgb(0, 0, 0)',
            data: [allShouts, shortShouts, longShouts],
        }]
    },

    // Configuration options go here
    options: {
    	  scales: {
    	        yAxes: [{
    	            gridLines: {
    	                offsetGridLines: true
    	            },
    	            ticks: {
    	            	beginAtZero: true,
    	            }
    	        }]
    	    },
    }
});

Chart.scaleService.updateScaleDefaults('bar', {
    ticks: {
        min: 0
    }
});
</script>