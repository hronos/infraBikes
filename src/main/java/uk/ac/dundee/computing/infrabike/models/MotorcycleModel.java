/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.dundee.computing.infrabike.models;

import java.sql.Connection;
import uk.ac.dundee.computing.infrabike.dao.MotorcycleDAO;
import uk.ac.dundee.computing.infrabike.dto.MotorcycleLo;

/**
 *
 * @author Anna
 */
public class MotorcycleModel {
    
    
    
    public MotorcycleLo findMotorcycle(int Id)
    {
        
    return null;    
    }
    
   public void addSpec( String name,int top_speed,int weight, int seat_height,String frame,
   int tank,int engineSize,int frontB,int rearB,int frontT,
    int rearT,int power,int serial,String colour,int price,int Id,Connection connection)
   {
        try {
            MotorcycleDAO c = new MotorcycleDAO();
            c.addSpec(name,top_speed,weight,seat_height,frame,tank,engineSize,frontB,rearB,frontT,rearT,power,serial,colour,price,weight,Id,connection);
        } catch (Exception e) {
            throw e;
        }
       
       
   }
   
   public void updateSpec(int idModel,String name,int top_speed,int weight, int seat_height,String frame,
   int tank,int engineSize,int frontB,int rearB,int frontT,
    int rearT,int power,int serial,String colour,int price,int Id,Connection connection)
   {
        try {
            MotorcycleDAO c = new MotorcycleDAO();
            c.updateSpec(idModel, name, top_speed, weight, seat_height, frame, tank, engineSize, frontT, rearT, frontT, engineSize, power,serial,colour,price, connection);
        } catch (Exception e) {
            throw e;
        }
   }
   
   public void addMotorcycle(int id,int serial,int id_part,Connection connection)
   {
        try {
            MotorcycleDAO c = new MotorcycleDAO();
            c.addMotorcycle(id,serial,id_part, connection);
        } catch (Exception e) {
            throw e;
        }
   }
   
}
