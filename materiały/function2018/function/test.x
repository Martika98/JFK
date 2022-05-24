read x

function fun
  write x
  x = 3
  write x
  fun = x
endfunction


zosia = fun
write zosia

ala = 1
write ala

function alax
  ala = 1234
  write ala
  alax = ala
endfunction

ala = alax

write ala


