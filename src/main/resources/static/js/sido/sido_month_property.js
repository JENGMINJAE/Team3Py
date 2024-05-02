

// 시도별 월별 2021년
const month21_1 = document.querySelector('#month21_1').value;
const month21_2 = document.querySelector('#month21_2').value;
const month21_3 = document.querySelector('#month21_3').value;
const month21_4 = document.querySelector('#month21_4').value;
const month21_5 = document.querySelector('#month21_5').value;
const month21_6 = document.querySelector('#month21_6').value;
const month21_7 = document.querySelector('#month21_7').value;
const month21_8 = document.querySelector('#month21_8').value;
const month21_9 = document.querySelector('#month21_9').value;
const month21_10 = document.querySelector('#month21_10').value;
const month21_11 = document.querySelector('#month21_11').value;
const month21_12 = document.querySelector('#month21_12').value;

// 시도별 월별 2022년
const month22_1 = document.querySelector('#month22_1').value;
const month22_2 = document.querySelector('#month22_2').value;
const month22_3 = document.querySelector('#month22_3').value;
const month22_4 = document.querySelector('#month22_4').value;
const month22_5 = document.querySelector('#month22_5').value;
const month22_6 = document.querySelector('#month22_6').value;
const month22_7 = document.querySelector('#month22_7').value;
const month22_8 = document.querySelector('#month22_8').value;
const month22_9 = document.querySelector('#month22_9').value;
const month22_10 = document.querySelector('#month22_10').value;
const month22_11 = document.querySelector('#month22_11').value;
const month22_12 = document.querySelector('#month22_12').value;

// 시도별 월별 2023년
const month23_1 = document.querySelector('#month23_1').value;
const month23_2 = document.querySelector('#month23_2').value;
const month23_3 = document.querySelector('#month23_3').value;
const month23_4 = document.querySelector('#month23_4').value;
const month23_5 = document.querySelector('#month23_5').value;
const month23_6 = document.querySelector('#month23_6').value;
const month23_7 = document.querySelector('#month23_7').value;
const month23_8 = document.querySelector('#month23_8').value;
const month23_9 = document.querySelector('#month23_9').value;
const month23_10 = document.querySelector('#month23_10').value;
const month23_11 = document.querySelector('#month23_11').value;
const month23_12 = document.querySelector('#month23_12').value;

new Chart(document.getElementById("line-chart"), { 
                    type: 'line', 
                    data: { 
                            labels: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'], 
                            datasets: [
                                
                                        {   
                                            data: [month21_1,month21_2,month21_3,month21_4,month21_5,month21_6,month21_7,month21_8,month21_9,month21_10,month21_11,month21_12], 
                                            label: "2021", 
                                            borderColor: "#3cba9f", 
                                            fill: false
                                        }, 
                                        { 
                                            data: [month22_1,month22_2,month22_3,month22_4,month22_5,month22_6,month22_7,month22_8,month22_9,month22_10,month22_11,month22_12], 
                                            label: "2022", 
                                            borderColor: "#e8c3b9", 
                                            fill: false 
                                        }, 
                                        { 
                                            data:[month23_1,month23_2,month23_3,month23_4,month23_5,month23_6,month23_7,month23_8,month23_9,month23_10,month23_11,month23_12], 
                                            label: "2023", 
                                            borderColor: "#c45850", 
                                            fill: false 
                                        } 
                                    ] 
                            }, 
                    options: { 
                                title: { display: false, text: '년도별/월별  화재 재산피해액' } 
                            } 
});



let my_td = document.getElementById('my_td');



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