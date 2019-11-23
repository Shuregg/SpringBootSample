function removeByJquery() {
    let element = $("#text-to-delete");
    element.remove();
}

function add() {
    let but2 = $("#info-btn");
    but2.after("<h1>Hello world!21</h1?>");
}




let colors = ["none", "none", "none", "none", "none", "none", "none", "none", "none"];


var current = "darksalmon";

function turn(number) {
    $("#s" + number).css("background-color", current);
//     $("#s" + number).animate({
//         backgroundColor: current
//     }, 500);
    colors[number - 1] = current;
    //console.log(colors);
    if (current === "darksalmon") {
        current = "palegoldenrod";
    } else {
        current = "darksalmon";
    }
    $("#s" + number).prop("disabled", true);
   
    
    var result = check();
    if(result != "none") {
          $("#result").animate({
        backgroundColor: result,
    }, 200); 
    }
  $("#result").text("Winner is " + result);    
}

function check() {
    var goldWins = 0;
    var bronzeWins = 0;
    var endOfGame = restart();
    for (let i = 0; i < 7; i += 3) {
        if (colors[0 + i] == colors[1 + i] && colors[1 + i] == colors[2 + i] && colors[2 + i] != "none") {
                        if(colors[2+ i] == "palegoldenrod") {
                alert("Golden player won!");
                goldWins +=1;
                return goldWins;
                endOfGame();
            } else {
               alert("Bronze player won!");
                bronzeWins += 1;
                return bronzeWins;
                endOfGame();
            }
            }
        }
        for (let i = 0; i < 2; i += 1) {
            if (colors[0 + i] == colors[3 + i] && colors[3 + i] == colors[6 + i] && colors[6 + i] != "none") {
                            if(colors[6 + i] == "palegoldenrod") {
                alert("Golden player won!");
                goldWins +=1;
                return goldWins;
                endOfGame();                
            } else {
               alert("Bronze player won!");
                bronzeWins += 1;
                return bronzeWins;
                endOfGame();
            }
            }
        }
        if(colors[0] == colors[4] && colors[4] == colors[8] && colors[8] != "none") {
                       if(colors[0] == "palegoldenrod") {
                alert("Golden player won!");
                goldWins +=1;
                return goldWins
                endOfGame();           
            } else {
               alert("Bronze player won!");
                bronzeWins += 1;
                return bronzeWins;
                endOfGame();
            }
        }
        if(colors[2] == colors[4] && colors[4] == colors[6] && colors[6] != "none") {
            if(colors[2] == "palegoldenrod") {
                alert("Golden player won!");
                goldWins +=1;
                return goldWins
                endOfGame();
            } else {
               alert("Bronze player won!");
                bronzeWins += 1;
                return bronzeWins;
                endOfGame();
            }  
        }
    
  let wasNone = false;
    for(let i = 0; i < 9; i++) {
        if(colors[i] == "none") {
            wasNone = true;
        }
    }
    if(wasNone = false) {
        return "draw";
    }
    return "none";

    
}

function restart() {
   let colors = ["none", "none", "none", "none", "none", "none", "none", "none", "none"];
    for(let i = 1; i < 10; i += 1) {
        $("#s" + i).prop("disabled", false);
    }
}

