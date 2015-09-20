/**
 * 19 сент. 2015 г.
 */
package ru.davist.study.vaadin.ui;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.annotations.Theme;
import com.vaadin.data.Container.Filterable;
import com.vaadin.data.util.BeanContainer;
import com.vaadin.data.util.ObjectProperty;
import com.vaadin.data.util.filter.Or;
import com.vaadin.data.util.filter.SimpleStringFilter;
import com.vaadin.event.FieldEvents.TextChangeEvent;
import com.vaadin.event.FieldEvents.TextChangeListener;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import ru.davist.study.vaadin.domain.Campaign;
import ru.davist.study.vaadin.service.CampaignService;

/**
 * @author StarovoytovD
 * 		
 */
@SpringUI(path = "/yuki")
@Theme("valo")
public class YukiUI extends UI {
	
	private Label selectedItem;
	private Table table;
	private TextField filterText;
	
	@Autowired
	private CampaignService campaignService;
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void init(VaadinRequest request) {
		Layout layout = initLayout();
		
		final ObjectProperty<String> prop = new ObjectProperty<String>("");
		selectedItem.setPropertyDataSource(prop);
		
		BeanContainer<String, Campaign> tableBean = new BeanContainer<>(Campaign.class);
		tableBean.setBeanIdProperty("id");
		tableBean.addAll(campaignService.getCampaigns());
		
		table.setContainerDataSource(tableBean);
		table.addItemClickListener(new ItemClickListener() {
			
			private static final long serialVersionUID = 1L;
			
			@Override
			public void itemClick(ItemClickEvent event) {
				prop.setValue(event.getItem().toString());
			}
		});
		
		filterText.addTextChangeListener(new TextChangeListener() {
			private static final long serialVersionUID = 1L;

			Or filter = null;
			
			@Override
			public void textChange(TextChangeEvent event) {
				Filterable f = (Filterable) table.getContainerDataSource();
				
				// Remove old filter
				if (filter != null)
					f.removeContainerFilter(filter);
					
				// Set new filter for the "Name" column
				filter = new Or(new SimpleStringFilter("name", event.getText(), true, false),
						new SimpleStringFilter("id", event.getText(), true, false),
						new SimpleStringFilter("start", event.getText(), true, false));
				f.addContainerFilter(filter);
			}
		});
		
		setContent(layout);
	}
	
	private Layout initLayout() {
		VerticalLayout layout = new VerticalLayout();
		
		selectedItem = new Label();
		
		filterText = new TextField();
		filterText.setInputPrompt("Фильтр");
		filterText.setImmediate(true);
		
		table = new Table("Акции");
		table.setSizeFull();
		table.setSelectable(true);
		table.setNullSelectionAllowed(false);
		table.setVisibleColumns("id", "name", "start", "end");
		table.setColumnCollapsible("id", false);
		table.setColumnCollapsingAllowed(true);
		table.setColumnReorderingAllowed(true);
		table.setColumnHeader("id", "#");
		table.setColumnHeader("name", "Название");
		table.setColumnHeader("start", "Начало");
		table.setColumnHeader("end", "Окончание");
		
		layout.addComponent(selectedItem);
		layout.addComponent(filterText);
		layout.addComponent(table);
		
		return layout;
	}
}
