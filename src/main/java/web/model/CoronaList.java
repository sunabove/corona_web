package web.model;

import java.util.List;

import org.springframework.data.domain.Page;

public class CoronaList extends ArrayList<Corona> { 
	
	private static final long serialVersionUID = -4059339497002917210L;

	public CoronaList() {
	}
	
	public CoronaList(Page<Corona> page) {
		List<Corona> list = page.getContent() ;
		if( null != list ) {
			this.addAll( list );
		}
	}
	
	public CoronaList(java.util.List<Corona> list) {
		super( list );
	}

}
