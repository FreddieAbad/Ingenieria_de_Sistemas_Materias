local dx, dy = canvas:attrSize()

function dibujarMenu(mensaje)
   
  canvas:attrColor('RED')
  canvas:drawRect('fill',0,0,dx,dy)
  canvas:attrColor('black')
  canvas:drawText(0, 5,mensaje) 
  canvas:flush()  
end


function handler(evt) 
  if evt.key~=null then
    if evt.class == 'key' then
      if evt.type == 'press' then       
         dibujarMenu(evt.key) 
      end 
    end 
  end   
end
dibujarMenu('hola')
event.register(handler)