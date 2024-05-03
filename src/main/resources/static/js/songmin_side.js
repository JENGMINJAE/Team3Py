///////////////////////////슬라이드//////////////////////////
const yearSongmin = document.querySelector("#yearSongmin").value;
fetch('/ranking/mainRankingFetch', { //요청경로
    method: 'POST',
    cache: 'no-cache',
    headers: {
        'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
    },
    //컨트롤러로 전달할 데이터
    body: new URLSearchParams({
       // 데이터명 : 데이터값
        selectYear : yearSongmin
    })
})
.then((response) => {
    if(!response.ok){
        alert('fetch error!\n컨트롤러로 통신중에 오류가 발생했습니다.');
        return ;
    }
    //return response.text(); //컨트롤러에서 return하는 데이터가 없거나 int, String 일 때 사용
    return response.json(); //나머지 경우에 사용
})
//fetch 통신 후 실행 영역
.then((datas) => {//data -> controller에서 리턴되는 데이터!
    document.querySelector("#ffn").innerHTML=`${datas.mainTopList1[0].placeBigType}`;
    document.querySelector("#ffc").innerHTML='';
    document.querySelector("#fsn").innerHTML=`${datas.mainTopList1[1].placeBigType}`;
    document.querySelector("#fsc").innerHTML='';
    document.querySelector("#ftn").innerHTML=`${datas.mainTopList1[2].placeBigType}`;
    document.querySelector("#ftc").innerHTML='';
    document.querySelector("#sfn").innerHTML=`${datas.mainTopList2[0].placeMediumType}`;
    document.querySelector("#sfc").innerHTML='';
    document.querySelector("#ssn").innerHTML=`${datas.mainTopList2[1].placeMediumType}`;
    document.querySelector("#ssc").innerHTML='';
    document.querySelector("#stn").innerHTML=`${datas.mainTopList2[2].placeMediumType}`;
    document.querySelector("#stc").innerHTML='';
    document.querySelector("#tfn").innerHTML=`${datas.mainTopList3[0].fireLocation}`;
    document.querySelector("#tfc").innerHTML='';
    document.querySelector("#tsn").innerHTML=`${datas.mainTopList3[1].fireLocation}`;
    document.querySelector("#tsc").innerHTML='';
    document.querySelector("#ttn").innerHTML=`${datas.mainTopList3[2].fireLocation}`;
    document.querySelector("#ttc").innerHTML='';
    
    mainTopList1.insertAdjacentHTML()
})
//fetch 통신 실패 시 실행 영역
.catch(err=>{
    alert('fetch error!\nthen 구문에서 오류가 발생했습니다.\n콘솔창을 확인하세요!');
    console.log(err);
});
