        var texto1 = document.getElementById("texto1")
        var texto2 = document.getElementById("texto2")

        function esAnagrama() {

            const t1 = texto1.value.trim().toLowerCase()
            const t2 = texto2.value.trim().toLowerCase()
           
            if (t1 === t2 || t1.length !== t2.length) {

                alert("NO son un anagrama")

            }

            const ordenada1 = t1.split('').sort().join('');
            const ordenada2 = t2.split('').sort().join('');

            if (ordenada1 === ordenada2) {

                alert("SON un anagrama")

            }

        }