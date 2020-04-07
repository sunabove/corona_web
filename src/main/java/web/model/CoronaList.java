package web.model;

import org.springframework.data.domain.Page;

import java.util.List;

public class CoronaList extends java.util.ArrayList<Corona> {
	
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
