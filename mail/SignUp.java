package com.mail;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class SignUp 
{

    static int mCode = 1;

	HashMap users = new HashMap(); 
	HashMap usersCheckExisting = new HashMap();

    public void startPage()
    {

        loadUsers();
        Scanner scan=new Scanner(System.in);

        System.out.println("ZMail");
        System.out.println("");

        System.out.println("1.New account");
        System.out.println("2.Login");
        System.out.println("3.Exit");

        String select;

        System.out.println("Enter your option :");
        select=scan.nextLine();

        
        if(select.equals("1"))   //for signup page 
        {
            signup();
        }
        

        else if(select.equals("2")) //login page
        {
            login();
        }

        else if(select.equals("3"))  //exit
        {
            System.out.println("Thank you !");
        }

        else
        {
            System.out.println("wrong input.!");
            System.out.println("");
            startPage();
        }

    }
    
	public void signup()
    {
    
        Scanner scan=new Scanner(System.in);

        System.out.println("Enter new username :");
        
        String username=scan.next();

        if(usersCheckExisting.containsKey(username))        //is new username existing
        {
            System.out.println("Username already exist.!  Try again..");
            System.out.println("");
            startPage();
        }

        else if(!username.endsWith("@z.com"))       //is new username endswith @z.com
        {
            System.out.println("Username must ends with \"@z.com\".. ");
            System.out.println("");
            startPage();
        }

        System.out.println("Enter new password :");
        String password=scan.next();

        usersCheckExisting.put(username, password);

        users.put(username ,new HashMap());
        
        ((HashMap)users.get(username)).put("sentMails",new HashMap());
        ((HashMap)users.get(username)).put("receivedMails",new HashMap());

        System.out.println(usersCheckExisting);

        System.out.println("Succesfully created");
        System.out.println("");

        startPage();
            
    }
	
	public void loadUsers()

    {
        try
        {

        BufferedReader getMCode=new BufferedReader(new FileReader("E:\\eclipse\\exercises\\src\\com\\mail\\files\\mCode.txt"));
        mCode=Integer.parseInt(getMCode.readLine());

        BufferedReader reader=new BufferedReader(new FileReader("E:\\eclipse\\exercises\\src\\com\\mail\\files\\usernamePassword.txt"));
            String getValue="";
            while((getValue=reader.readLine())!=null)
            {
                String[] arr=getValue.split(" ");
                usersCheckExisting.put(arr[0],arr[1]);

                users.put(arr[0],new HashMap());
                HashMap userHashMap=(HashMap)users.get(arr[0]);

                userHashMap.put("sentMails",new HashMap());
                userHashMap.put("receivedMails",new HashMap());
               
            }

            reader=new BufferedReader(new FileReader("E:\\eclipse\\exercises\\src\\com\\mail\\files\\usernamePassword.txt"));
            String getString="";
            String mailString="";
            while((getString=reader.readLine())!=null)
            {
                String[] arr=getString.split(" ");
                HashMap mail=new HashMap();
                BufferedReader sentMailRead=new BufferedReader(new FileReader("E:\\eclipse\\exercises\\src\\com\\mail\\files\\"+arr[0]+"SentMails.txt"));
                while((mailString=sentMailRead.readLine())!=null)
                {
                    String[] sentMailArray=mailString.split("~");
                    mail =new HashMap();
                    for(int i=0; i<sentMailArray.length; i++)
                    {
                        if(i==1)
                        {
                           mail.put("from",sentMailArray[1]); 
                        }
                        else if(i==2)
                        {
                           mail.put("to",sentMailArray[2]); 
                        }
                        else if(i==3)
                        {
                           mail.put("subject",sentMailArray[3]); 
                        }
                        else if(i==4)
                        {
                           mail.put("message",sentMailArray[4]); 
                        }
                    }

                    HashMap userSentMails=(HashMap)((HashMap)users.get(arr[0])).get("sentMails");
                    userSentMails.put(sentMailArray[0],mail);
                }
             
            }

            reader=new BufferedReader(new FileReader("E:\\eclipse\\exercises\\src\\com\\mail\\files\\usernamePassword.txt"));
            getString="";
            mailString="";
            while((getString=reader.readLine())!=null)
            {
                String[] arr=getString.split(" ");
                HashMap mail=new HashMap();
                BufferedReader receivedMailRead=new BufferedReader(new FileReader("E:\\eclipse\\exercises\\src\\com\\mail\\files\\"+arr[0]+"ReceivedMails.txt"));
                while((mailString=receivedMailRead.readLine())!=null)
                {
                    String[] receivedMailArray=mailString.split("~");
                    mail =new HashMap();
                    for(int i=0; i<receivedMailArray.length; i++)
                    {
                        if(i==1)
                        {
                           mail.put("from",receivedMailArray[1]); 
                        }
                        else if(i==2)
                        {
                           mail.put("to",receivedMailArray[2]); 
                        }
                        else if(i==3)
                        {
                           mail.put("subject",receivedMailArray[3]); 
                        }
                        else if(i==4)
                        {
                           mail.put("message",receivedMailArray[4]); 
                        }
                    }
                    
					HashMap userReceivedMails=(HashMap)((HashMap)users.get(arr[0])).get("receivedMails");
                    userReceivedMails.put(receivedMailArray[0],mail);

                }
            }
        }

        catch(IOException e)
        {
            e.printStackTrace();
        }

    }

    private void addMailDetails(String from,String to, String subject, String message ,HashMap fromUsermenu)
    {
        HashMap mail=new HashMap();           //method to add mail details to users map.

        mail.put("from",from);
        mail.put("to",to);
        mail.put("subject",subject);
        mail.put("message",message);

        fromUsermenu.put("m"+ ++mCode, mail);
    }
    
    private void userMenu(String usernameFromLogin, String passwordFromLogin)  //user menu method
    {
        String username=usernameFromLogin;
        String password=passwordFromLogin;
        Scanner scan=new Scanner(System.in);

        System.out.println("1.Compose :");
        System.out.println("2.List Mails :");
        System.out.println("3.List sent mails :");
        System.out.println("4.Delete Mail :");
        System.out.println("5.Delete sent Mail :");
        System.out.println("6.Logout :");
        String selectAtLogin=scan.nextLine();

        if(selectAtLogin.equals("1"))     //compose mail page
        {
    
            System.out.println("");
            System.out.println("From : " +username);

            System.out.println("To : ");
            String to=scan.nextLine();
            System.out.println(to);
            String[] toValues=to.split(",");
            for(int i=0; i<toValues.length; i++)
            {
                if(!usersCheckExisting.containsKey(toValues[i]))
                {
                    System.out.println("username not existing.! try again.. : ");
                    userMenu(username,password);
                    return;
                }
            }

            System.out.println("Subject :");
            String subject=scan.nextLine();

            System.out.println("Message :");
            String message=scan.nextLine();

            if(message=="")
            {
                System.out.println("can't send empty message");
                userMenu(username,password);
                return;
            }

            HashMap sentMailMapFromCompose =((HashMap)((HashMap)users.get(username)).get("sentMails"));     
                addMailDetails(username,to,subject,message,sentMailMapFromCompose);
            
            for(int i=0;i<toValues.length;i++)
            {
                HashMap receivedMailMapFromCompose=((HashMap)((HashMap)users.get(toValues[i])).get("receivedMails"));
                addMailDetails(username,to,subject,message,receivedMailMapFromCompose); 
            }
            
            System.out.println("Successfully mail sent.");
            System.out.println("");

            userMenu(username,password);
        }

        else if(selectAtLogin.equals("2"))       //list received mails
        {
            HashMap receivedMailsFromUsermenu=((HashMap)((HashMap)users.get(username)).get("receivedMails"));
            Set<String> mailKeyset=receivedMailsFromUsermenu.keySet();

            if(receivedMailsFromUsermenu.size()==0)
            {
                System.out.println("No messages");
                System.out.println("");
            }
            
            else
            {
            for(String key : mailKeyset)
            {
                System.out.println("MsgId:"+key+" : "+receivedMailsFromUsermenu.get(key));
                System.out.println("");
            }
            }

            userMenu(username,password);
            
        }

        else if(selectAtLogin.equals("3"))       //list sent mails
        {
            HashMap sentMailsFromUsermenu=((HashMap)((HashMap)users.get(username)).get("sentMails"));
            Set<String> mailKeyset=sentMailsFromUsermenu.keySet();
            
            if(sentMailsFromUsermenu.size()==0)
            {
                System.out.println("No messages");
                System.out.println("");
            }
            
            else{
            for(String key : mailKeyset)
            {
                System.out.println("MsgId:"+key+" : "+sentMailsFromUsermenu.get(key));
                System.out.println("");
            }
            }

            userMenu(username,password);

        }

        else if(selectAtLogin.equals("4"))       //delete received mails
        {
            HashMap receivedMailsFromUsermenu=((HashMap)((HashMap)users.get(username)).get("receivedMails"));
            Set<String> mailKeyset=receivedMailsFromUsermenu.keySet();
            
            for(String key : mailKeyset)
            {
                System.out.println("MsgId:"+key+" "+receivedMailsFromUsermenu.get(key));
            }
            
            System.out.println("Enter the message id to delete :");
            String deleteId=scan.next();

            if(!receivedMailsFromUsermenu.containsKey(deleteId))
            {
                System.out.println("No msg id found.!");
                System.out.println("");
            }
            else
            {
                receivedMailsFromUsermenu.remove(deleteId);
                System.out.println("Deleted.");
                System.out.println("");
            }
            userMenu(username,password);

        }

        else if(selectAtLogin.equals("5"))       //delete sent mails
        {
            HashMap sentMailsFromUsermenu=((HashMap)((HashMap)users.get(username)).get("sentMails"));
            Set<String> mailKeyset=sentMailsFromUsermenu.keySet();
            
            for(String key : mailKeyset)
                {
                    System.out.println("MsgId:"+key+" "+sentMailsFromUsermenu.get(key));
                    System.out.println("");
                }
            
                System.out.println("Enter the message id to delete :");
                String deleteId=scan.next();

                if(!sentMailsFromUsermenu.containsKey(deleteId))
                {
                    System.out.println("No msg id found.!");
                    System.out.println("");
                }
                else
                {
                    sentMailsFromUsermenu.remove(deleteId);
                    System.out.println("Deleted.");
                    System.out.println("");
                }
                userMenu(username,password);
        }

        else if(selectAtLogin.equals("6"))       //logout
        {
        try
        {


            HashMap usersCheckMap=(HashMap)usersCheckExisting;;
            Set<String> usersCheck=usersCheckMap.keySet();
            FileWriter newUser=new FileWriter("E:\\eclipse\\exercises\\src\\com\\mail\\files\\usernamePassword.txt",false);
            BufferedWriter newUserBuffer=new BufferedWriter(newUser);
            newUserBuffer.flush();
            newUserBuffer.close();
            String writeLine="";

            for (String key:usersCheck)
            {
            writeLine=key+" "+usersCheckMap.get(key);

            newUser=new FileWriter("E:\\eclipse\\exercises\\src\\com\\mail\\files\\usernamePassword.txt",true);
            newUserBuffer=new BufferedWriter(newUser);
            newUserBuffer.write(writeLine);
            newUserBuffer.newLine();
            newUserBuffer.close();
            }
            
            for (String key:usersCheck)
            {
            HashMap userSentMailMap=(HashMap)((HashMap)users.get(key)).get("sentMails");
            Set<String> userSentMailMapKey=userSentMailMap.keySet();

            FileWriter writer=new FileWriter("E:\\eclipse\\exercises\\src\\com\\mail\\files\\"+key+"SentMails.txt",false);
            BufferedWriter bw=new BufferedWriter(writer);
            bw.flush();
            bw.close();
            

                
                for(String key1: userSentMailMapKey)
                {
                    HashMap mailFromSent=(HashMap)userSentMailMap.get(key1);

                    writeLine=key1+"~";
                    writeLine=writeLine+mailFromSent.get("from")+"~";
                    writeLine=writeLine+mailFromSent.get("to")+"~";
                    writeLine=writeLine+mailFromSent.get("subject")+"~";
                    writeLine=writeLine+mailFromSent.get("message");

                    writer=new FileWriter("E:\\eclipse\\exercises\\src\\com\\mail\\files\\"+key+"SentMails.txt",true);
                    bw=new BufferedWriter(writer);
                    bw.write(writeLine);
                    bw.newLine();
                    bw.close();
                }
                

            HashMap userReceivedMailMap=(HashMap)((HashMap)users.get(key)).get("receivedMails");
            Set<String> userReceivedMailMapKey=userReceivedMailMap.keySet();
            
            

            FileWriter writerReceived=new FileWriter("E:\\eclipse\\exercises\\src\\com\\mail\\files\\"+key+"ReceivedMails.txt",false);
            BufferedWriter bwReceived=new BufferedWriter(writerReceived);
            bwReceived.flush();
            bwReceived.close();
            

                writeLine="";
                for(String key1: userReceivedMailMapKey)
                {
                    HashMap mailFromReceived=(HashMap)userReceivedMailMap.get(key1);

                    writeLine=key1+"~";
                    writeLine=writeLine+mailFromReceived.get("from")+"~";
                    writeLine=writeLine+mailFromReceived.get("to")+"~";
                    writeLine=writeLine+mailFromReceived.get("subject")+"~";
                    writeLine=writeLine+mailFromReceived.get("message");

                    writerReceived=new FileWriter("E:\\eclipse\\exercises\\src\\com\\mail\\files\\"+key+"ReceivedMails.txt",true);
                    bwReceived=new BufferedWriter(writerReceived);
                    bwReceived.write(writeLine);
                    bwReceived.newLine();
                    bwReceived.close();
                }    
            }
            FileWriter setMCode=new FileWriter("E:\\eclipse\\exercises\\src\\com\\mail\\files\\mCode.txt");
            setMCode.write(String.valueOf(mCode));
            setMCode.close();

            System.out.println("Successfully Logged Out");
            System.out.println("");
            startPage();
        }
            catch(IOException e) 
        {  
            e.printStackTrace();  
        } 
        }

            else
        {
            System.out.println("Not a valid key.");
            System.out.println("");
            userMenu(username,password);
        }
    }

    private void login()        //login page
    {

        Scanner scan=new Scanner(System.in);

        System.out.println("Enter your Username : ");
        String username=scan.next();

        System.out.println("Enter your Password : ");
        String password=scan.next();

        if(!usersCheckExisting.containsKey(username))
        {
            System.out.println("Username or password incorrect.! Try again..");
            System.out.println("");
        }

        else if(!usersCheckExisting.get(username).equals(password))
        {
            System.out.println("Username or password incorrect.! Try again.");
            System.out.println("");
        } 
    
        else if(usersCheckExisting.get(username).equals(password))
        {
            System.out.println("");
            userMenu(username,password);
            return;
        }
        startPage();
	    
	}
}
