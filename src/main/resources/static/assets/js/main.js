const add = document.querySelector(".add");
const adds = document.querySelector(".adds");
const mcollection = document.getElementById("mcollection");
const scollection = document.getElementById("scollection");
const post = document.getElementById("post");
const listvalue = document.getElementById("listvalue");
const mchoicelist = document.getElementById("mChoiceList");
const schoicelist = document.getElementById("sChoiceList");
const list = document.getElementById("list");
let postArry ;
$(function () {
    $("#singlechoice").click(function () {
        postArry=[];
        while (mcollection.firstChild) {
            mcollection.removeChild(mcollection.firstChild);
        }
        $("#multichoicetoggle").hide();
        $("#singlechoicetoggle").slideToggle(200);
    });
});

$(function () {
    $("#multichoice").click(function () {
        postArry=[];
        while (scollection.firstChild) {
            scollection.removeChild(scollection.firstChild);
        }
        $("#singlechoicetoggle").hide();
        $("#multichoicetoggle").slideToggle(200);
    });
});

add.addEventListener("click", function (e) {
    const li = document.createElement('li');
    li.className = 'collection-item';
    li.appendChild(document.createTextNode(mchoicelist.value));
    const link = document.createElement("a");
    link.className = 'delete-item secondary-content';
    link.innerHTML = '<i class="material-icons">close</i>';
    li.appendChild(link);
    mcollection.appendChild(li);
    postArry.push(mchoicelist.value);
    console.log(mchoicelist.value);
    mchoicelist.value = "";

    e.preventDefault();
});
adds.addEventListener("click", function (e) {
    const li = document.createElement('li');
    li.className = 'collection-item';
    li.appendChild(document.createTextNode(schoicelist.value));
    const link = document.createElement("a");
    link.className = 'delete-item secondary-content';
    link.innerHTML = '<i class="material-icons">close</i>';
    li.appendChild(link);
    scollection.appendChild(li);
    postArry.push(schoicelist.value);
    schoicelist.value = "";

    e.preventDefault();
});

post.addEventListener("click", function () {
    listvalue.value = postArry;
});