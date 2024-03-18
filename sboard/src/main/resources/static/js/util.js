async function fetchData(url){

    try{
        const response = await fetch(url);
        console.log("here1");

        if(!response.ok){
            console.log("here2");
            throw new Error('response not ok');
        }

        const data = await response.json();
        console.log("data1 : " + data);

        return data;

    }catch (err) {
        console.log(err)
    }
}

function showModal(message){
    const modal = document.getElementById('resultModal');
    modal.getElementsByClassName('modal-body')[0].innerText = message;
    const resultModal = new bootstrap.Modal(modal);
    resultModal.show();
}