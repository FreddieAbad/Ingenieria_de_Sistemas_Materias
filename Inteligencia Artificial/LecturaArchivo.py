

import pandas as pd
FileNAME="Nodo.xlsx"
DAT= pd.ExcelFile(FileNAME)
#print(DAT.sheet_names)
df = DAT.parse("Hoja1")
header=list(df)
print(df.values)


"""
FileNAME="datos.xlsx"
DATx= pd.ExcelFile(FileNAME,header=1)
DATx.sheet_names
DATx = DATx.parse("DATA-1")
DATx.head()
"""


portabilidad (app peq o grande)
bajos recursos (mejor que maquinas virtuales) 
escalable
aislamiento (contenedores independiene)
autosuficiente 
inmutable (si cierro pc corre en servidor, comportamiento no cambia por so)