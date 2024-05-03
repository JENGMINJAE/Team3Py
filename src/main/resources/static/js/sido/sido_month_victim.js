
let monthVic2021List=[]
let monthVic2022List=[]
let monthVic2023List=[]

// 데이터 불러오기
let oneV = Array.prototype.slice.call(document.querySelectorAll(".oneVic"));
let twoV = Array.prototype.slice.call(document.querySelectorAll(".twoVic"));
let threeV = Array.prototype.slice.call(document.querySelectorAll(".threeVic"));


// //////////////////////월별 인명피해 그래프////////////////////

// 2021
oneV.forEach(function(one1){
    monthVic2021List.push(one1.value);    
})
console.log(monthVic2021List);
// 2022
twoV.forEach(function(two2){
    monthVic2022List.push(two2.value);
})
console.log(monthVic2022List);
// 2023
threeV.forEach(function(three3){
    monthVic2023List.push(three3.value);    
})
console.log(monthVic2023List);



new Chart(document.getElementById("line-chart4"), 
{ 
    type: 'line', 
    data: { 
        labels: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'], 

        datasets: [
            { 
                data: monthVic2021List, 
                label: "2021년도", 
                borderColor: "#3e95cd", 
                fill: false 
            }, 
            { 
                data: monthVic2022List, 
                label: "2022년도", 
                borderColor: "#8e5ea2", 
                fill: false 
            }, 
            { 
                data: monthVic2023List, 
                label: "2023년도", 
                borderColor: "#c45850", 
                fill: false 
            }
        ] 
    }, 
    options: { 
        title: { display: false, text: 'World population per region (in millions)' }, 
        responsive: false,
        scales : {yAxes:[{
        
            ticks: {
                display :true,  stepSize: 200,  max:800,
                min: 0 }
        }]
        
        }

    } 

});