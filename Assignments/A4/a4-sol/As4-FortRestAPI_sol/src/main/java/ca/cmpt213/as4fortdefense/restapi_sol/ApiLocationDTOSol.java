package ca.cmpt213.as4fortdefense.restapi_sol;

import ca.cmpt213.as4fortdefense.model.Coordinate;
import ca.cmpt213.as4fortdefense.restapi.ApiLocationDTO;

/**
 * SOLUTION: Complete the API DOT with factory methods
 */
public class ApiLocationDTOSol extends ApiLocationDTO {
    public static ApiLocationDTO fromCellLocation(Coordinate cell) {
        ApiLocationDTO locationDto = new ApiLocationDTO();
        locationDto.row = cell.getRowIndex();
        locationDto.col = cell.getColIndex();
        return locationDto;
    }
    public static Coordinate toCellLocation(ApiLocationDTO cell) {
        return new Coordinate(cell.row, cell.col);
    }
}
