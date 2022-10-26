package org.sitrack.sopaletras.model;

import java.util.List;
import java.util.UUID;

import org.sitrack.sopaletras.dto.Rows;
import org.sitrack.sopaletras.dto.Soup;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "soups")
public class SoapEntityExtend extends SoupEntity  {
	
	 private Soup soup;

}
