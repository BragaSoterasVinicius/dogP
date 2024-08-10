
window.addEventListener("load", ()=>{
    draw();
})

function draw() {
    
    let isDrawing = false;
    tamanhoBrush = 10;
    const canvas = document.querySelector("canvas"),
    ctx = canvas.getContext("2d");

    window.addEventListener("load", () =>{
        canvas.width = canvas.offsetX;
        log(canvas.width);
        canvas.height = canvas.offsetY;
        log(canvas.height);
    });
    

    image1 = new Image();
    //dps coloca o cachorro
    //image1.src = 'dogp.png';
    const setCanvasBackground = () => {
        ctx.fillStyle = '#fff';
        ctx.fillRect(0,0, canvas.width, canvas.height);
        ctx.fillStyle = "#fff";
    }
    const startDrawing = () => {
        isDrawing = true;
        ctx.beginPath();
        ctx.lineWidth = tamanhoBrush;
    }
    const drawing = (e) => {
        if(!isDrawing) return;
        ctx.lineTo(e.offsetX, e.offsetY);
        ctx.stroke();
        ctx.drawImage(image1, 0, 0, canvas.width, canvas.height);
    }
    setCanvasBackground()
    canvas.addEventListener("mousedown", startDrawing);
    canvas.addEventListener("mousemove", drawing);
    canvas.addEventListener("mouseup", () => isDrawing = false);
}
function sendToJavaTron(){
    //lembrar de alterar esses métodos para transformar a imagem em um cachorro quando tudo estiver mais hospedado
        // Convert canvas to data URL
        const canvas = document.getElementById('canvas');
        const context = canvas.getContext('2d');
        const dataURL = canvas.toDataURL('image/png');

        // Send the data URL to the server using Fetch API
        fetch('/uploadCanvas', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ imageData: dataURL })
        })
            .then(response => response.text())
            .then(data => {
                console.log('Success:', data);
            })
            .catch((error) => {
                console.error('Error:', error);
            });
}
function apagar(){
    console.log("apagar");
    const canvas = document.querySelector("canvas"),
    ctx = canvas.getContext("2d");
    ctx.fillStyle = '#fff';
    ctx.fillRect(0,0, canvas.width, canvas.height);
    ctx.fillStyle = "#fff";
}