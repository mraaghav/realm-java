/*
 * Copyright 2020 Realm Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.realm.entities.embedded

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

// Top-level node in a object-graph that is three-shaped, i.e. no circular references.
// The tree depth can be described as:
// - 1 TreeParent
// - 1 or more TreeNodes. I.e. a TreeNode can be the child of another TreeNode.
// - 1 or more TreeLeaf objects. TreeLeaf objects are always at the bottom of tree.
open class EmbeddedTreeParent(@PrimaryKey var _id: String = UUID.randomUUID().toString()) : RealmObject() {
    var middleNode: EmbeddedTreeNode? = null
    var middleNodeList: RealmList<EmbeddedTreeNode> = RealmList()
}
