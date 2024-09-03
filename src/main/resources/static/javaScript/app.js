let form = document.querySelector(".formulario");
let inputs = document.querySelectorAll(".input");
let palvraValues = []


form.addEventListener("submit", function(event){
    event.preventDefault();

    
    inputs.forEach(inputs => {
        
        palvraValues.push(inputs.value);
        console.log(inputs.value)
    
    });

    console.log(palvraValues);

    const dados ={
        palavra: palvraValues[0],
        significado: palvraValues[1],
        nome: palvraValues[2],
        dicionario: palvraValues[3],
    }

    console.log(dados);


})

