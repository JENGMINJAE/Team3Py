// 주제별 화재통계 - 주제별 버튼 클릭 시 그래프
function showContent(contentId, button) {
  // 모든 버튼 'btn-clicked' 클래스 제거
  document.querySelectorAll('.btn-clicked').forEach(btn => {
      btn.classList.remove('btn-clicked');
  });

  // 선택 버튼 'btn-clicked' 클래스 추가
  button.classList.add('btn-clicked');

  // 선택 버튼 내용 표시
  var contents = document.querySelectorAll('.content');
  contents.forEach(content => {
      if (content.id === contentId) {
          content.style.display = 'block';
      } else {
          content.style.display = 'none';
      }
  });
}


////////////////////////////막대그래프 - 발화장소 3개년//////////////////////////
fetch('/statistics/detailFirePlaceFetch', {
  method: 'POST',
  cache: 'no-cache',
  headers: {
      'Content-Type': 'application/json'
  },
  // 컨트롤러로 전달할 데이터
  body: JSON.stringify({})
})
.then((response) => {
  if (!response.ok) {
      alert('fetch error!\n컨트롤러로 통신중에 오류가 발생했습니다.');
      return;
  }

  return response.json();
})
.then((data) => {
  const placeLabels = data.totalFirePlace.map(place => place.placeBigType); // 장소 라벨
  const placeCounts = data.totalFirePlace.map(place => place.count); // 장소 카운트

  new Chart(document.getElementById("bar-chart"), {
      type: 'bar',
      data: {
          labels: placeLabels, // 장소 라벨
          datasets: [
              {
                  label: "발화 장소",
                  data: placeCounts, // 카운트
                  backgroundColor: [
                      'rgba(255, 99, 132, 0.8)',
                      'rgba(255, 159, 64, 0.8)',
                      'rgba(255, 205, 86, 0.8)',
                      'rgba(75, 192, 192, 0.8)',
                      'rgba(54, 162, 235, 0.8)'
                  ],
                  datalabels : {
                    anchor: 'end', // 표시 위치 
                    align: 'top',  // 표시 위치 배치 방향
                }
              }
          ]
      },
      options: {
          responsive: false,
          legend: { display: false }
      }
  });
})
.catch((error) => {
  console.error('Fetch error:', error);
});


//////////////////////////원그래프 (1) - 발화장소 2021//////////////////////
fetch('/statistics/firePlaceFetch', {
  method: 'POST',
  cache: 'no-cache',
  headers: {
      'Content-Type': 'application/json'
  },
  // 컨트롤러로 전달할 데이터
  body: JSON.stringify({})
})
.then((response) => {
  if (!response.ok) {
      alert('fetch error!\n컨트롤러로 통신중에 오류가 발생했습니다.');
      return;
  }
  return response.json();
})
.then((data) => {
  const threshold = 400; // 임계값 설정
  const placeLabels = data.firePlace2021.map(place => place.placeBigType); // 장소 라벨
  const placeCounts = data.firePlace2021.map(place => place.count); // 카운트
  let total = data.firePlace2021[0].count // 데이터 첫 번쨰 요소 count값 = 연간 토탈값
  
  // 400미만 데이터 '기타'로 묶음
  let otherCount = 0;
  const filteredLabels = [];
  const filteredCounts = [];
  for (let i = 0; i < placeCounts.length; i++) {
    if (placeCounts[i] < threshold) {
      otherCount += placeCounts[i];
    } else {
      filteredLabels.push(placeLabels[i]);
      filteredCounts.push(placeCounts[i]);
    }
  }
  filteredLabels.push('그 외');
  filteredCounts.push(otherCount);

  // 첫 번째 요소 토탈 값 제외
  const chartDataLabels = filteredLabels.slice(1);
  const chartDataCounts = filteredCounts.slice(1);

  new Chart(document.getElementById("pie-chart-1"), {
    type: 'pie',
    data: {
      labels: chartDataLabels, // 장소 라벨
      datasets: [
        {
          label: "발화 장소",
          data: chartDataCounts, //카운트
          backgroundColor: [
            'rgba(255, 99, 132, 0.8)',
            'rgba(255, 159, 64, 0.8)',
            'rgba(255, 205, 86, 0.8)',
            'rgba(75, 192, 192, 0.8)',
            'rgba(54, 162, 235, 0.8)',
            'rgba(153, 102, 255, 0.8)'
          ]
        }
      ]
    },
    options: {
      responsive: false,
      title: {
        display: true,
        text: '2021년 발화장소 합계 | ' + total,
        fontSize : 20
      }
    }
  });
})


////////////////////////원그래프 (2) - 발화장소 2022////////////////////
fetch('/statistics/firePlaceFetch', {
  method: 'POST',
  cache: 'no-cache',
  headers: {
      'Content-Type': 'application/json'
  },
  // 컨트롤러로 전달할 데이터
  body: JSON.stringify({})
})
.then((response) => {
  if (!response.ok) {
      alert('fetch error!\n컨트롤러로 통신중에 오류가 발생했습니다.');
      return;
  }
  return response.json();
})
.then((data) => {
  const threshold = 400; // 임계값 설정
  const placeLabels = data.firePlace2022.map(place => place.placeBigType); // 장소 라벨
  const placeCounts = data.firePlace2022.map(place => place.count); // 카운트
  let total = data.firePlace2022[0].count // 데이터 첫 번쨰 요소 count값 = 연간 토탈값

  // 400미만 데이터 '기타'로 묶음
  let otherCount = 0;
  const filteredLabels = [];
  const filteredCounts = [];
  for (let i = 0; i < placeCounts.length; i++) {
    if (placeCounts[i] < threshold) {
      otherCount += placeCounts[i];
    } else {
      filteredLabels.push(placeLabels[i]);
      filteredCounts.push(placeCounts[i]);
    }
  }
  filteredLabels.push('그 외');
  filteredCounts.push(otherCount);

  // 첫 번째 요소 토탈 값 제외
  const chartDataLabels = filteredLabels.slice(1);
  const chartDataCounts = filteredCounts.slice(1);

  new Chart(document.getElementById("pie-chart-2"), {
    type: 'pie',
    data: {
      labels: chartDataLabels, // 장소 라벨
      datasets: [
        {
          label: "발화 장소",
          data: chartDataCounts, //카운트
          backgroundColor: [
            'rgba(255, 99, 132, 0.8)',
            'rgba(255, 159, 64, 0.8)',
            'rgba(255, 205, 86, 0.8)',
            'rgba(75, 192, 192, 0.8)',
            'rgba(54, 162, 235, 0.8)',
            'rgba(153, 102, 255, 0.8)'
          ]
        }
      ]
    },
    options: {
      responsive: false,
      title: {
        display: true,
        text: '2022년 발화장소 합계 | ' + total,
        fontSize: 20
      }
    }
  });
})
.catch((error) => {
  console.error('Fetch error:', error);
});


/////////////////////원그래프 (3) - 발화장소 2023/////////////////
fetch('/statistics/firePlaceFetch', {
  method: 'POST',
  cache: 'no-cache',
  headers: {
      'Content-Type': 'application/json'
  },
  // 컨트롤러로 전달할 데이터
  body: JSON.stringify({})
})
.then((response) => {
  if (!response.ok) {
      alert('fetch error!\n컨트롤러로 통신중에 오류가 발생했습니다.');
      return;
  }
  return response.json();
})
.then((data) => {
  const threshold = 2000; // 임계값 설정
  const placeLabels = data.firePlace2023.map(place => place.placeBigType); // 장소 라벨
  const placeCounts = data.firePlace2023.map(place => place.count); // 카운트
  let total = data.firePlace2023[0].count // 데이터 첫 번쨰 요소 count값 = 연간 토탈값

  // 1000미만 데이터 '기타'로 묶기
  let otherCount = 0;
  const filteredLabels = [];
  const filteredCounts = [];
  for (let i = 0; i < placeCounts.length; i++) {
    if (placeCounts[i] < threshold) {
      otherCount += placeCounts[i];
    } else {
      filteredLabels.push(placeLabels[i]);
      filteredCounts.push(placeCounts[i]);
    }
  }
  filteredLabels.push('그 외');
  filteredCounts.push(otherCount);

  // 첫 번째 요소 토탈 값 제외
  const chartDataLabels = filteredLabels.slice(1);
  const chartDataCounts = filteredCounts.slice(1);

  new Chart(document.getElementById("pie-chart-3"), {
    type: 'pie',
    data: {
      labels: chartDataLabels, // 장소 라벨
      datasets: [
        {
          label: "발화 장소",
          data: chartDataCounts, //카운트
          backgroundColor: [
            'rgba(255, 99, 132, 0.8)',
            'rgba(255, 159, 64, 0.8)',
            'rgba(255, 205, 86, 0.8)',
            'rgba(75, 192, 192, 0.8)',
            'rgba(54, 162, 235, 0.8)',
            'rgba(153, 102, 255, 0.8)'
          ]
        }
      ]
    },
    options: {
      responsive: false,
      title: {
        display: true,
        text: '2023년 합계 | ' + total,
        fontSize: 20
      }
    }
  });
})
.catch((error) => {
  console.error('Fetch error:', error);
});





// // 원그래프 (3) - 발화장소 2023
// new Chart(document.getElementById("pie-chart-3"), {
//   type: 'pie',
//   data: {
//     labels: ["1", "2", "3", "4", "5", "6", "7"],
//     datasets: [{
//         label: "test1",
//         data: [2478, 5267, 734, 784, 433, 600, 1000],
//         backgroundColor: [
//           //색상
//           'rgba(255, 99, 132, 0.8)',
//           'rgba(255, 159, 64, 0.8)',
//           'rgba(255, 205, 86, 0.8)',
//           'rgba(75, 192, 192, 0.8)',
//           'rgba(54, 162, 235, 0.8)',
//           'rgba(153, 102, 255, 0.8)',
//           'rgba(201, 203, 207, 0.8)'
//         ]
//       }
//     ]
//   },
//   options: {
//     responsive: false,
//     title: {
//       display: true,
//       text: 'Predicted world population (millions) in 2050'
//     }
//   }
// });
