/* globals Chart:false */

(() => {
    'use strict';

    // Lấy tham chiếu đến canvas
    const ctx = document.getElementById('myChart');

    // Sử dụng Fetch API để lấy dữ liệu từ servlet
    fetch('chartData') // Thay thế '/yourContextPath' bằng đường dẫn thực tế của bạn
        .then(response => response.json())
        .then(data => {
            // Vẽ biểu đồ khi dữ liệu đã được nhận được
            const myChart = new Chart(ctx, {
                type: 'line',
                data: {
                    labels: JSON.parse(data.labels), // Parse chuỗi JSON thành mảng nhãn
                    datasets: [{
                        data: JSON.parse(data.data), // Parse chuỗi JSON thành mảng dữ liệu
                        lineTension: 0,
                        backgroundColor: 'transparent',
                        borderColor: '#007bff',
                        borderWidth: 4,
                        pointBackgroundColor: '#007bff'
                    }]
                },
                options: {
                    plugins: {
                        legend: {
                            display: false
                        },
                        tooltip: {
                            boxPadding: 3
                        }
                    }
                }
            });
        })
        .catch(error => {
            console.error('Error fetching data:', error);
        });
})();
