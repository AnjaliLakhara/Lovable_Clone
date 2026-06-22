package com.SpringProject.Lovable_Clone.dto.project;

import java.time.Instant;

public record ProjectSummaryResponse(
    Long id,
    String name,
    Instant createdAt
    
) {

}
