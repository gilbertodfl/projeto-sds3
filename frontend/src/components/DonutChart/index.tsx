import axios from 'axios';
import { useEffect, useState } from 'react';
import Chart from 'react-apexcharts';
import { BASE_URL} from 'utils/requests';
import { SaleSum} from 'types/sale';

type ChartData = {
    labels: string[];
    series: number[]
}
const DonutChart = () => {

    const [chartData, setChartData ]= useState<ChartData>( { labels:[], series: []} );

    useEffect( () => {
        axios.get( `${BASE_URL}/sales/amount-by-seller`)
        .then( response => {
    
            const data = response.data as SaleSum[];
            const myLabels = data.map( x => x.sellerName);
            const mySeries = data.map( x => x.sum);
    
            setChartData( { labels: myLabels, series: mySeries});
          });
    }, []);
    // OBSERVAÇÃO: SE NÃO TIVER OS COLCHETES ACIMA , [] , ENTRA EM LOOP!!!!


    const options = {
        legend: {
            show: true
        }
    }
    

    // ...options indica que vc pega o valor anterior e ainda acrescenta mais outros parametoros, 
    // algo como options=options e mais alguma coisa. 
    return (
        <Chart 
            //options={{...options, labels: mockData.labels  }}
            options={{...options, labels: chartData.labels  }}
            series={chartData.series}
            type="donut"
            height="240"
        
        />
     
    );
}

export default DonutChart;
