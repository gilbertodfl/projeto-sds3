import Chart from 'react-apexcharts';

const BarChart = () => {
    const options = {
        plotOptions: {
            bar: {
                horizontal: true,
            }
        },
    };
    
    const mockData = {
        labels: {
            categories: ['Anakin', 'Barry Allen', 'Kal-El', 'Logan', 'Padmé']
        },
        series: [
            {
                name: "% Sucesso",
                data: [43.6, 67.1, 67.7, 45.6, 71.1]                   
            }
        ]
    };
    // ...options indica que vc pega o valor anterior e ainda acrescenta mais outros parametoros, 
    // algo como options=options e mais alguma coisa. 
    return (
        <Chart 
            options={{...options, xaxis: mockData.labels  }}
            series={mockData.series}
            type="bar"
            height="240"
        
        />
     
    );
}

export default BarChart;
