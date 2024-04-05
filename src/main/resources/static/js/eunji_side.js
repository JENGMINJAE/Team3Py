// https://observablehq.com/@rabelais/rendering-topojson-of-south-korea-with-d3-v5@66

  import * as topojson from 'https://cdn.skypack.dev/topojson@3.0.2';
  import * as d3 from 'https://cdn.skypack.dev/d3@v5.15.0';

  const topoDataPath = '/json/topoKorea.json';

  async function loadTopoData() {
    const response = await fetch(topoDataPath);
    return await response.json();
}

function getGeoJson(topoData) {
    return topojson.feature(topoData, topoData.objects.skorea_provinces_2018_geo);
}

function getRenderData() {
    return {
        width: 550,
        height: 540,
        margin: 0,
    };
}

async function main() {
    const topoData = await loadTopoData();
    const renderData = getRenderData();

    const tooltip = d3.select("#tooltip"); // 툴팁 요소 선택

    const geoJson = getGeoJson(topoData);
    const svg = d3
        .create('svg')
        .attr('width', renderData.width)
        .attr('height', renderData.height);

        
    const pathGen = d3.geoPath().projection(d3.geoMercator().fitSize([renderData.width, renderData.height], geoJson));

    
    svg.selectAll('.province')
        .data(geoJson.features)
        .enter().append('path')
        .attr('d', pathGen)
        .attr('fill', '#cacaca')
        .attr('stroke', '#000000')
        .on('mouseenter', function(event, d) {
            d3.select(this).attr('fill', '#ff8800');
            tooltip
                .style("display", "block") // 툴팁 표시
                .text(d.properties.name)
                .style("left", (event.pageX + 10) + "px")
                .style("top", (event.pageY + 10) + "px");
        })
        .on('mouseleave', function() {
            d3.select(this).attr('fill', '#cacaca');
            tooltip.style("display", "none"); // 툴팁 숨김
        });

    document.querySelector('#map').appendChild(svg.node());
}

main();


  // async function loadTopoData() {
  //   const response = await fetch(topoDataPath)
  //   return await response.json();
  // }

  // function getGeoJson(topoData) {
  //   return topojson.feature(topoData, topoData.objects.skorea_provinces_2018_geo);
  // }

  // function getRenderData() {
  //   return {
  //     width: 550,
  //     height: 540,
  //     margin: 5,
  //   };
  // }

  // function renderMap(topoData, renderData) {
  //   const geoJson = getGeoJson(topoData);
  //   const svg = d3
  //     .create('svg')
  //     .attr('width', renderData.width)
  //     .attr('height', renderData.height);

  //   const tooltip = d3.select("#tooltip");

  //   const pathGen = d3.geoPath().projection(d3.geoMercator().fitSize([renderData.width, renderData.height], geoJson));

  //   svg.selectAll('.province')
  //     .data(geoJson.features)
  //     .enter().append('path')
  //     .attr('d', pathGen)
  //     .attr('fill', '#cacaca')
  //     .attr('stroke', '#000000')
  //     .on('mouseenter', function(event, d) {
  //       d3.select(this).attr('fill', '#ff8800');
  //       tooltip
  //         .style("visibility", "visible")
  //         .text(d.properties.name)
  //         .style("left", (event.pageX + 10) + "px")
  //         .style("top", (event.pageY + 10) + "px");
  //     })
  //     .on('mouseleave', function() {
  //       d3.select(this).attr('fill', '#cacaca');
  //       tooltip.style("visibility", "hidden");
  //     });

  //   return svg.node();
  // }

  // async function main() {
  //   const topoData = await loadTopoData();
  //   const renderData = getRenderData();
  //   const mapElement = renderMap(topoData, renderData);

  //   document.querySelector('#map').appendChild(mapElement);
  // }

  // main();
  