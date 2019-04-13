package ClientDidi;


import org.primefaces.model.chart.PieChartModel;

import ConsomDidi.StatService;
import Entity.Project;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
@ManagedBean
@ViewScoped
public class PieBean  {
	
	//private PieChartModel pieModel1;
   private String pieChartData;
   private String pieChartData2;
    
    public String getPieChartData2() {
	return pieChartData2;
}

public void setPieChartData2(String pieChartData2) {
	this.pieChartData2 = pieChartData2;
}




	@EJB
   	 StatService sgService;

	private List<Object[]> user;
	private List<Object[]> proj;
	
    
    @PostConstruct
    public void init() {
    	System.out.println("aaaaaaaa");
    	user = sgService.getAllCostumer();
    	proj=sgService.getAllProj();
    	populateData();
    	Pie();
    
    	System.out.println(pieChartData);
    }
    
    public List<Object[]> getProj() {
		return proj;
	}

	public void setProj(List<Object[]> proj) {
		this.proj = proj;
	}

	public List<Object[]> getUser() {
		return user;
	}

	public void setUser(List<Object[]> user) {
		this.user = user;
	}

	public String getPieChartData() {
		return pieChartData;
	}

	public void setPieChartData(String pieChartData) {
		this.pieChartData = pieChartData;
	}

	public StatService getSgService() {
		return sgService;
	}

	public void setSgService(StatService sgService) {
		this.sgService = sgService;
	}

/* String name = (String) result[0];
    int count = ((Number) result[1]).intValue();*/

	private void populateData() {
    	StringBuilder stringBuilder = new StringBuilder("['State', 'nb proj'],");
    	for (Object[] pieData : user) {
    	stringBuilder.append("[");
    	stringBuilder.append("'");
    	stringBuilder.append(String.valueOf(pieData[1]));
    	stringBuilder.append("'");
    	stringBuilder.append(",");
    	stringBuilder.append(String.valueOf(pieData[0]));
    	stringBuilder.append("]");
    	stringBuilder.append(",");
    	}
    	pieChartData = stringBuilder.toString().substring(0,
    	stringBuilder.toString().length() - 1);
    	}


	
	
	private void Pie() {
    	StringBuilder stringBuilder = new StringBuilder("['Description', 'nb ressource'],");
    	for (Object[] pieData : proj) {
    	stringBuilder.append("[");
    	stringBuilder.append("'");
    	stringBuilder.append(String.valueOf(pieData[1]));
    	stringBuilder.append("'");
    	stringBuilder.append(",");
    	stringBuilder.append(String.valueOf(pieData[0]));
    	stringBuilder.append("]");
    	stringBuilder.append(",");
    	}
    	pieChartData2 = stringBuilder.toString().substring(0,
    	stringBuilder.toString().length() - 1);
    	}

    
    

}
