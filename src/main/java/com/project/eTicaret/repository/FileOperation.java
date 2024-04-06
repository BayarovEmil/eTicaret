package com.project.eTicaret.repository;

import com.project.eTicaret.entity.Customer;

import java.io.*;

public class FileOperation implements FileRepository {
    @Override
    public void add(Customer user) {
        try(BufferedWriter writer=new BufferedWriter(new FileWriter("data.txt",true))){
            writer.write(user.getId()+", "+user.getName()+", "+user.getEmail()+", "+user.getPassword()+"\n");
        } catch (Exception e) {
            System.out.println("Xəta mejaı " + e.getMessage());
        }
    }

    @Override
    public void findAll() {
        try{
            BufferedReader reader=new BufferedReader(new FileReader("data.txt"));
            String line;
            while((line=reader.readLine())!=null){
                System.out.println(line);
            }
            reader.close();
        }catch (IOException e){
            System.out.println("Xəta mejaı "+e.getMessage());
        }
    }

    @Override
    public boolean isEmailExist(String email) {
        try{
            BufferedReader reader=new BufferedReader(new FileReader("data.txt"));
            String line;
            while((line=reader.readLine())!=null){
                String[] parts = line.split(", ");
                if (parts[2].equals(email)) {
                    return true;
                }
            }
            reader.close();
        }catch (IOException e){
            System.out.println("Xəta mejaı "+e.getMessage());
        }
        return false;
    }

    @Override
    public String findByEmail(String email) {
        String password="";
        try{
            BufferedReader reader=new BufferedReader(new FileReader("data.txt"));
            String line;
            while((line=reader.readLine())!=null){
                String[] parts = line.split(", ");
                if (parts[2].equals(email)) {
                    password = parts[3];
                    return password;
                }
            }
            reader.close();
        }catch (IOException e){
            System.out.println("Xəta mejaı "+e.getMessage());
        }
        return password;
    }
}
