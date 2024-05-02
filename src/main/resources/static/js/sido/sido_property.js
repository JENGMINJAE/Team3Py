function gokoung(sidoBtn){
    alert(sidoBtn.value);
    const sidoNm = sidoBtn.value;
    location.href='/sido/sidoMonth?sidoNm='+sidoNm;
}




let one2021List=[]
let two2022List=[]
let three2023List=[]

// 데이터 불러오기
let ones = Array.prototype.slice.call(document.querySelectorAll(".one"));
let twos = Array.prototype.slice.call(document.querySelectorAll(".two"));
let threes = Array.prototype.slice.call(document.querySelectorAll(".three"));




// 2021
ones.forEach(function(one){
    one2021List.push(one.value);
    
})
console.log(one2021List);
// 2022
twos.forEach(function(two){
    two2022List.push(two.value);
    
})
console.log(two2022List);

// 2023
threes.forEach(function(three){
    three2023List.push(three.value);
    
})
console.log(three2023List)

new Chart(document.getElementById("line-chart"), 
{ 
    type: 'line', 
    data: { 
        labels: ['강원', '경기', '경남', '경북', '광주', '대구',
                    '대전', '부산', '서울', '세종', '울산', 
                    '인천', '전남', '전북', '제주', '충남' , '충북'], 

        datasets: [
            { 
                data: one2021List, 
                label: "2021년도", 
                borderColor: "#3e95cd", 
                fill: false 
            }, 
            { 
                data: two2022List, 
                label: "2022년도", 
                borderColor: "#8e5ea2", 
                fill: false 
            }, 
            { 
                data: three2023List, 
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
                display :true,  stepSize: 200000000,  max:800000000,
                min: 0 }
        }]
        
        }

    } 

});




//  숫자를 한글로 읽기
function convertToKoreanNumber(numk) { 
    
    let num = numk.innerText
    console.log(num);

    let result = ''; 
    let digits = ['영','일','이','삼','사','오','육','칠','팔','구']; 
    let units = ['', '십', '백', '천', '만', '십', '백', '천', '억', '십억', '백억', '천억', '조', '십조', '백조', '천조']; 
    let numStr = num.toString(); // 문자열로 변환 
    let numLen = numStr.length; // 문자열의 길이 
    
        for(let i=0; i<numLen; i++){
            
            let digit = parseInt(numStr.charAt(i)); // i번째 자릿수 숫자 
            let unit = units[numLen-i-1]; // i번째 자릿수 단위 
        
                // 일의 자리인 경우에는 숫자를 그대로 한글로 변환 
                if(i === numLen-1 && digit === 1 && numLen !== 1) { 
                    result += '일'; 
                } 
                else if(digit !== 0) { 
                    // 일의 자리가 아니거나 숫자가 0이 아닐 경우 
                    result += digits[digit] + unit; 
                } 
                else if(i === numLen-5) { 
                    // 십만 단위에서는 '만'을 붙이지 않습니다. 
                    result += '만'; 
                }
                            
        }
        console.log(result);
        numk.title=result;
        return result; 
}
        
