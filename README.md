# TURNUS

[![License: GPL v3](https://img.shields.io/badge/License-GPL%20v3-blue.svg)](http://www.gnu.org/licenses/gpl-3.0) [![Build Status](https://travis-ci.org/turnus/turnus.svg?branch=master)](https://travis-ci.org/turnus/turnus) 

A design space exploration and optimization framework for dynamic dataflow programs.

## Download

The Eclipse plugins can be downloaded from this repository:

```
http://scistimm.epfl.ch/turnus/eclipse/
```


Please make sure to use the latest [Eclipse Neon](http://www.eclipse.org/downloads/packages/eclipse-rcp-and-rap-developers/neon1a) *for RCP and RAP Developers*.

## Build from sources
If you want to build the latest version from the sources you should clone all the repositories and successively use maven to build all the plugins. Here an example:

```
mkdir turnus
cd turnus
git clone https://github.com/turnus/turnus.git
git clone https://github.com/turnus/turnus.orcc.git
git clone https://github.com/turnus/turnus.p2.git
cd turnus.p2
mvn clean install
```

---

# How to cite


```
@article{casalebrunet,
      title = {Analysis and optimization of dynamic dataflow programs},
      author = {Casale-Brunet, Simone},
      institution = {IEL},
      publisher = {EPFL},
      address = {Lausanne},
      year = {2015},
}

@inproceedings{turnus, 
	author={S. Casale-Brunet and M. Mattavelli and J. Janneck}, 
	booktitle={2013 IEEE International Symposium on Circuits and Systems (ISCAS2013)}, 
	title={{TURNUS}: A design exploration framework for dataflow system design}, 
	year={2013},  
	pages={654-654},
	doi={10.1109/ISCAS.2013.6571927}, 
	ISSN={0271-4302}, 
	month={May},
}

```



