var jsonData = {
    details: []
};

 const setDetailsMaterial =(index)=>{
     let value = document.getElementById(`details[${index}].materialId`).value;
     for (let i = 0 ; i < jsonData.details.length;i++){
         if(i === index){
             jsonData.details[i].materialId = value;
         }
     }
 }
 const setDetailsQuantity=(index)=>{
     let value = document.getElementById(`details[${index}].quantity`).value;
     for (let i = 0 ; i < jsonData.details.length;i++){
         if(i === index){
             jsonData.details[i].quantity = value;
         }
     }
 }
 

 
document.addEventListener('DOMContentLoaded', function () {
    let productIndex = 0;

    // Xử lý thêm sản phẩm
    document.getElementById('addProductBtn').addEventListener('click', function () {
        const tbody = document.getElementById('materials');
        jsonData = {...jsonData,details:[...jsonData.details, {
            materialId: null,
            quantity: null
        }]};
       
        // Tạo dòng mới
        const newRow = document.createElement('tr');
        newRow.classList.add('materials');
        newRow.innerHTML = `
            
            <td>
                <input type="number" step="1.0" id="details[${productIndex}].quantity" class="form-control" onchange="setDetailsQuantity(1)" required />
            </td>
            <td>
                <button type="button" class="btn btn-danger remove-btn">Xóa</button>
            </td>
        `;

        // Thêm dòng mới vào bảng
        tbody.appendChild(newRow);
        productIndex++;
    });

    // Xử lý xóa sản phẩm
    document.getElementById('materials').addEventListener('click', function (event) {
        if (event.target.classList.contains('remove-btn')) {
            const row = event.target.closest('tr');
            row.remove();
        }
    });
});



function CreateOder(url, urlIndex) {
    event.preventDefault();
    var form = document.getElementById("orderForm");
    var isValid = true;
    var expectDate = (form.querySelector('#expectDate').value);
    var totalCost= (form.querySelector('#totalCost').value);
    

}




