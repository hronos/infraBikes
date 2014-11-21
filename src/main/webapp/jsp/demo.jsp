

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <link href="../dynatable/jquery.dynatable.css" rel="stylesheet" type="text/css"/>
        <script src="http://code.jquery.com/jquery-1.7.2.min.js" type="text/javascript"></script>
        <script src="http://code.highcharts.com/highcharts.js" type="text/javascript"></script>
        <script src="../dynatable/jquery.dynatable.js" type="text/javascript"></script>
        <style type="text/css">
            #usr-span {
                display: none;
            }
        </style>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Users</title>
        
        
        <script>
              // getting JSON from the document works, but of what use is that?
            $(document).ready( function() {
            var json = (${demo});
            var $users = [${demo}];
            var obj = ${demo};
            
            input = JSON.stringify(obj);
            
            $("#usr-span").html(input);
            
            
              $('#population').dynatable({
                dataset: {
                  records: JSON.parse($('#usr-span').text())
                },
                table: {
                  copyHeaderClass: true
                },
                writers: {
                    link: function(v) {
                    return '<a href="Users/'+v.username+'">Edit</a>';
                    }   
                }
              }); 
            });
        </script>    
    </head>
    <body>
        
 <div class="center">
<div id="chart-example-chart" style="margin: 0 auto"></div>
<a class="btn primary" id="toggle-chart-table">Show Table to Sort the Chart Series</a>
<span id="usr-span"></span>

<table id="test" class="table table-bordered">
  <thead><tr><th>City</th><th>Population</th></tr></thead>
  <tbody>
    <tr><td>Central</td><td>2124698</td></tr>
    <tr><td>East</td><td>6543216</td></tr>
    <tr><td>Highlands</td><td>321547</td></tr>
    <tr><td>London</td><td>8321065</td></tr>
    <tr><td>Midlands</td><td>6845321</td></tr>
    <tr><td>MidWales</td><td>1202365</td></tr>
    <tr><td>NorthEast</td><td>231231</td></tr>
    <tr><td>NorthEastScotland</td><td>987624</td></tr>
    <tr><td>NorthernIreland</td><td>1800231</td></tr>
    <tr><td>NorthWales</td><td>986321</td></tr>
    <tr><td>NorthWest</td><td>6321658</td></tr>
    <tr><td>SouthEast</td><td>5789463</td></tr>
    <tr><td>SouthScotland</td><td>675231</td></tr>
    <tr><td>SouthWales</td><td>279865</td></tr>
    <tr><td>SouthWest</td><td>7689432</td></tr>
    <tr><td>WestScotland</td><td>1190987</td></tr>
    <tr><td>WestWales</td><td>638546</td></tr>
    <tr><td>Yorkshire</td><td>6987653</td></tr>
  </tbody>
</table>
<script>
    (function() {
  var $table = $('#test'), $chart = $('#chart-example-chart'), chart;

  // Create a button to toggle our table's visibility.
  // We could just hide it completely if we don't need it.
  $('#toggle-chart-table').click(function(e) {
    e.preventDefault();
    $table.toggle();
  });

  // Set up our Highcharts chart
  chart = new Highcharts.Chart({
    chart: {
      type: 'column',
      renderTo: 'chart-example-chart'
    },
    title: {
      text: 'Population per region'
    },
    yAxis: {
      min: 0,
      title: {
        text: 'Population'
      }
    },
    series: [{
      name: 'population',
      color: '#006A72'
    }]
  });

  // Create a function to update the chart with the current working set
  // of records from dynatable, after all operations have been run.
  function updateChart() {
    var dynatable = $table.data('dynatable'), categories = [], values = [];
    $.each(dynatable.settings.dataset.records, function() {
      categories.push(this.city);
      values.push(parseFloat(this.population));
    });

    chart.xAxis[0].setCategories(categories);
    chart.series[0].setData(values);
  };

  // Attach dynatable to our table, hide the table,
  // and trigger our update function whenever we interact with it.
  $table
    .dynatable({
      inputs: {
        queryEvent: 'blur change keyup',
        recordCountTarget: $chart,
        paginationLinkTarget: $chart,
        searchTarget: $chart,
        perPageTarget: $chart
      },
      dataset: {
        perPageOptions: [5, 10, 20],
        sortTypes: {
          'population': 'number'
        }
      }
    })
    .hide()
    .bind('dynatable:afterProcess', updateChart);

  // Run our updateChart function for the first time.
  updateChart();
})();
</script>  
<footer>@Project done by Group 4 for AC32006/AC52001 module</footer>  </div>
</body>
</html>
