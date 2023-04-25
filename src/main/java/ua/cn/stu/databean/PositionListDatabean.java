package ua.cn.stu.databean;

import java.util.List;
import ua.cn.stu.dao.HibernateDAOFactory;
import ua.cn.stu.domain.Position;

public class PositionListDatabean {
	private List<Position> positionList;

	public PositionListDatabean() {
		positionList = HibernateDAOFactory.getInstance().getPositionDAO().getAllPositions();
	}

	public List<Position> getPositionList() {
		return positionList;
	}

	public void setPositionList(List<Position> positionList) {
		this.positionList = positionList;
	}
}