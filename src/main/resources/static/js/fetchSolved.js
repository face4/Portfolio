$(function(){
    fetchAtCoder();
    fetchCodeforces();
    fetchYukicoder();
    fetchAoj();
});

function updateSum(val){
    $("#sum").text(parseInt($("#sum").text())+val);
}

function fetchAtCoder(){
    $.ajax({
        url:"https://kenkoooo.com/atcoder/resources/ac.json",
        type:"GET",
        datatype:"json"
    }).done(function(data1,textStatus,jqXHR){
        Object.keys(data1).forEach(function (key){
            if(data1[key]["user_id"]==="face4"){
                $("#AtCoder").empty();
                $("#AtCoder").text(data1[key]["problem_count"]);
                updateSum(data1[key]["problem_count"]);
            }
        });
    }).fail(function(jqXHR, textStatus, errorThrown){
        $("#AtCoder").empty();
        $("#AtCoder").text("0 (Service Unavailable)");
    }).always(function(){
        console.log("done.");
    })
}

function fetchYukicoder(){
    $.ajax({
        url:"https://yukicoder.me/api/v1/user/id/5429",
        type:"GET",
        datatype:"json"
    }).done(function(data1,textStatus,jqXHR){
        $("#Yukicoder").empty();
        $("#Yukicoder").text(data1["Solved"]);
        updateSum(data1["Solved"]);
    }).fail(function(jqXHR, textStatus, errorThrown){
        $("#Yukicoder").empty();
        $("#Yukicoder").text("0 (Service Unavailable)");
    }).always(function(){
        console.log("done.");
    })
}

function fetchCodeforces(){
    $.ajax({
        url:"https://codeforces.com/api/user.status?handle=face4",
        type:"GET",
        datatype:"json"
    }).done(function(data1,textStatus,jqXHR){
        let accepted = new Set();
        data1["result"].forEach(function(sub){
            if(sub["verdict"]==="OK"){
                accepted.add(sub["problem"]["contestId"]+sub["problem"]["index"]);
            }
        });
        $("#Codeforces").empty();
        $("#Codeforces").text(accepted.size);
        updateSum(accepted.size);
    }).fail(function(jqXHR, textStatus, errorThrown){
        $("#Codeforces").empty();
        $("#Codeforces").text("0 (Service Unavailable)");
    }).always(function(){
        console.log("done.");
    })
}

function fetchAoj(){
    $.ajax({
        url:"https://judgeapi.u-aizu.ac.jp/users/face4",
        type:"GET",
        datatype:"json"
    }).done(function(data1,textStatus,jqXHR){
        $("#Aoj").empty();
        $("#Aoj").text(data1["status"]["solved"]);
        updateSum(data1["status"]["solved"]);
    }).fail(function(jqXHR, textStatus, errorThrown){
        $("#Aoj").empty();
        $("#Aoj").text("0 (Service Unavailable)");
    }).always(function(){
        console.log("done.");
    })
}


