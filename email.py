import smtplib

try:  
    server = smtplib.SMTP('smtp.gmail.com', 587)
    server.ehlo()
    server.starttls()
    server.login("xhensilapoda1@gmail.com", "xhensila1995")
 
    msg = "mail was sent succesfully"
    server.sendmail("xhensilapoda1@gmail.com", "serverroom999@gmail.com", msg)
   
except:  
    print ('Something went wrong...')
