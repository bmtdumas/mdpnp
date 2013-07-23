package org.mdpnp.clinicalscenarios.client.user.comparator;

import java.lang.reflect.Method;
import java.util.Comparator;

import org.mdpnp.clinicalscenarios.client.user.UserInfoProxy;

/**
 * Basic comparator for users <p>
 * @author diego@mdpnp.org <p>
 *
 */
public class UserComparator implements Comparator<UserInfoProxy> {

	private String userProperty;//property name
	private boolean reverseOrder;
	
	
	
	public UserComparator(String prop){
		this.userProperty = prop;
		reverseOrder = false;
	}
	
	public UserComparator(String prop, boolean b){
		this.userProperty = prop;
		reverseOrder = b;
	}
	
	//getter and setter
	public String getPersonProperty() {
		return userProperty;
	}

	public void setPersonProperty(String personProperty) {
		this.userProperty = personProperty;
	}
	
	public void switcReverseOrder(){
		reverseOrder = ! reverseOrder;
	}
	
	
	
	/**
	 * Compares two users based on the member variables of the class.
	 * If the property provided is not in the UserInfoProxy class
	 * it will return 0 and won�t establish and other.
	 *  String type properties will be sorted lexicografically
	 */
		public int compare(UserInfoProxy user1, UserInfoProxy user2) {
			//XXX CAREFUL!! Check the property is NOT NULL
		      if(reverseOrder)
		    	  return -1*( user1.getEmail().compareToIgnoreCase(user2.getEmail()) );  
		      else
		    	  return user1.getEmail().compareToIgnoreCase(user2.getEmail()) ; 
		      
//		      diego@mdpnp.org
//		      I don't really want to, but if reflexion doesn't work we are going to need to add
//		      one method/property for each property in the UserInfoProxy class, and maintain that when ned properties are added
		      
//			 Class<?> myclass = user1.getClass();  
//			 String getter = "get" + Character.toUpperCase(this.userProperty.charAt(0)) + userProperty.substring(1);
//			 try {  
//				 Method getPropiedad = myclass.getMethod(getter);  
//			       
//			     Object property1 = getPropiedad.invoke(user1);  
//			     Object property2 = getPropiedad.invoke(user2);  
//			     			     
//			     if(property1 instanceof Comparable && property2 instanceof Comparable) {  
//			      Comparable prop1 = (Comparable)property1;  
//			      Comparable prop2 = (Comparable)property2;  
//			      if(reverseOrder)
//			    	  return -1*( prop1.compareTo(prop2) );  
//			      else
//			    	  return prop1.compareTo(prop2) ;  
//			     } 
//			     else { //IF THEY ARE NOT COMPARABLE 
//			    	 return 0;//doesn�t compare /sort		  
//			     }  		    
//			    }  
//			    catch(Exception e) {  
//			    	//NoSuchMethod
//			    	e.printStackTrace();  
//			    	return 0;//Doesn�t compare/sort
//			    } 
		}
		
		public int compare(String o1, String o2) {
			if(null == o1) {
				if(null == o2) {
					return 0;
				} else {
					return -1;
				}
			} else {
				if(null == o2) {
					return 1;
				} else {
					return o1.toUpperCase().compareTo(o2.toUpperCase());
				}
			}
		}
		
}

